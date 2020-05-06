package com.oraclechain.pocketrix.blockchain;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lzy.okgo.model.Response;
import com.oraclechain.pocketrix.R;
import com.oraclechain.pocketrix.app.ActivityUtils;
import com.oraclechain.pocketrix.base.BaseUrl;
import com.oraclechain.pocketrix.base.Constants;
import com.oraclechain.pocketrix.bean.ResponseBean;
import com.oraclechain.pocketrix.bean.SendRedPacketBean;
import com.oraclechain.pocketrix.blockchain.api.rixChainInfo;
import com.oraclechain.pocketrix.blockchain.bean.GetRequiredKeys;
import com.oraclechain.pocketrix.blockchain.bean.JsonToBeanResultBean;
import com.oraclechain.pocketrix.blockchain.bean.JsonToBinRequest;
import com.oraclechain.pocketrix.blockchain.bean.PushSuccessBean;
import com.oraclechain.pocketrix.blockchain.bean.RequreKeyResult;
import com.oraclechain.pocketrix.blockchain.chain.Action;
import com.oraclechain.pocketrix.blockchain.chain.PackedTransaction;
import com.oraclechain.pocketrix.blockchain.chain.SignedTransaction;
import com.oraclechain.pocketrix.blockchain.cypto.ec.rixPrivateKey;
import com.oraclechain.pocketrix.blockchain.types.TypeChainId;
import com.oraclechain.pocketrix.blockchain.util.GsonrixTypeAdapterFactory;
import com.oraclechain.pocketrix.modules.transaction.redpacket.anticipationredpacket.AnticipationRedPacketActivity;
import com.oraclechain.pocketrix.net.HttpUtils;
import com.oraclechain.pocketrix.net.callbck.JsonCallback;
import com.oraclechain.pocketrix.utils.BigDecimalUtil;
import com.oraclechain.pocketrix.utils.JsonUtil;
import com.oraclechain.pocketrix.utils.PublicAndPrivateKeyUtils;
import com.oraclechain.pocketrix.utils.ShowDialog;
import com.oraclechain.pocketrix.utils.ToastUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by pocketrix on 2018/5/2.
 * rixX适配
 */

public class rixDataManger {
    static String RIXCONTRACT = Constants.RIXCONTRACT;
    static String OCTCONTRACT =  Constants.OCTCONTRACT;//erctoken
    static String ACTIONTRANSFER = Constants.ACTIONTRANSFER;
    static String PERMISSONION = Constants.PERMISSONION;

    Context mContext;
    rixChainInfo mChainInfoBean = new rixChainInfo();
    JsonToBeanResultBean mJsonToBeanResultBean = new JsonToBeanResultBean();
    String[] permissions;
    SignedTransaction txnBeforeSign;
    Gson mGson = new GsonBuilder()
            .registerTypeAdapterFactory(new GsonrixTypeAdapterFactory())
            .excludeFieldsWithoutExposeAnnotation().create();

    String contract, action, message, userpassword;
    int type = 1; //0即为红包 ， 1为转账
    SendRedPacketBean.DataBean redpacketInfo = new SendRedPacketBean.DataBean(); // 红包信息
    String redpacketNumber = null;
    BigDecimal coinRate;//资产汇率

    public rixDataManger(Context context, String password) {
        mContext = context;
        this.userpassword = password;
    }




    public void pushAction(String message, String permissionAccount) {
        this.message = message;
        if (message.contains("RIX")) {
            this.contract = RIXCONTRACT;
        } else {
            this.contract = OCTCONTRACT;
        }
        this.action = ACTIONTRANSFER;
        this.type = 1;
        permissions = new String[]{permissionAccount + "@" + PERMISSONION};
        getChainInfo();
    }

    public void getChainInfo() {
        HttpUtils.getRequets(BaseUrl.HTTP_get_chain_info, this, new HashMap<String, String>(), new JsonCallback<ResponseBean>() {
            @Override
            public void onSuccess(Response<ResponseBean> response) {
                if (response.body().code == 0) {
                    mChainInfoBean = (rixChainInfo) JsonUtil.parseStringToBean(mGson.toJson(response.body().data), rixChainInfo.class);
                    getabi_json_to_bin();
                } else {
                    if (ShowDialog.dialog != null) {
                        ShowDialog.dissmiss();
                    }
                    ToastUtils.showLongToast(response.body().message);
                }
            }
        });
    }

    public void getabi_json_to_bin() {

        JsonToBinRequest jsonToBinRequest = new JsonToBinRequest(contract, action, message.replaceAll("\\r|\\n", ""));
        HttpUtils.postRequest(BaseUrl.HTTP_get_abi_json_to_bin, this, mGson.toJson(jsonToBinRequest), new JsonCallback<ResponseBean>() {
            @Override
            public void onSuccess(Response<ResponseBean> response) {
                if (response.body().code == 0) {
                    mJsonToBeanResultBean = (JsonToBeanResultBean) JsonUtil.parseStringToBean(mGson.toJson(response.body().data), JsonToBeanResultBean.class);
                    txnBeforeSign = createTransaction(contract, action, mJsonToBeanResultBean.getBinargs(), permissions, mChainInfoBean);
                    //扫描钱包列出所有可用账号的公钥
                    List<String> pubKey =  PublicAndPrivateKeyUtils.getActivePublicKey();

                    getRequreKey(new GetRequiredKeys(txnBeforeSign, pubKey));
                } else {
                    if (ShowDialog.dialog != null) {
                        ShowDialog.dissmiss();
                    }
                    ToastUtils.showLongToast(response.body().message);
                }
            }
        });
    }

    private SignedTransaction createTransaction(String contract, String actionName, String dataAsHex,
                                                String[] permissions, rixChainInfo chainInfo) {

        Action action = new Action(contract, actionName);
        action.setAuthorization(permissions);
        action.setData(dataAsHex);


        SignedTransaction txn = new SignedTransaction();
        txn.addAction(action);
        txn.putSignatures(new ArrayList<String>());


        if (null != chainInfo) {
            txn.setReferenceBlock(chainInfo.getHeadBlockId());
            txn.setExpiration(chainInfo.getTimeAfterHeadBlockTime(30000));
        }
        return txn;
    }

    public void getRequreKey(GetRequiredKeys getRequiredKeys) {

        HttpUtils.postRequest(BaseUrl.HTTP_get_required_keys, this, mGson.toJson(getRequiredKeys), new JsonCallback<ResponseBean>() {
            @Override
            public void onSuccess(Response<ResponseBean> response) {
                if (response.body().code == 0) {
                    RequreKeyResult requreKeyResult = (RequreKeyResult) JsonUtil.parseStringToBean(mGson.toJson(response.body().data), RequreKeyResult.class);
                    rixPrivateKey rixPrivateKey = new rixPrivateKey(PublicAndPrivateKeyUtils.getPrivateKey(requreKeyResult.getRequired_keys().get(0), userpassword));
                    txnBeforeSign.sign(rixPrivateKey, new TypeChainId(mChainInfoBean.getChain_id()));
                    pushTransactionRetJson(new PackedTransaction(txnBeforeSign));
                } else {
                    if (ShowDialog.dialog != null) {
                        ShowDialog.dissmiss();
                    }
                    ToastUtils.showLongToast(response.body().message);
                }
            }
        });

    }

    public void pushTransactionRetJson(PackedTransaction body) {
        HttpUtils.postRequest(BaseUrl.HTTP_push_transaction, this, mGson.toJson(body), new JsonCallback<ResponseBean>() {
            @Override
            public void onSuccess(final Response<ResponseBean> response) {

                if (response.body().code == 0) {
                    PushSuccessBean.DataBeanX dataBeanX = (PushSuccessBean.DataBeanX) JsonUtil.parseStringToBean(mGson.toJson(response.body().data), PushSuccessBean.DataBeanX.class);
                    final Bundle bundle = new Bundle();
                    if (type == 1) {
                        if (ShowDialog.dialog != null) {
                            ShowDialog.dissmiss();
                        }
                        ToastUtils.showLongToast(R.string.transfersuccess);
                        bundle.putString("account", dataBeanX.getProcessed().getAction_traces().get(0).getAct().getData().getFrom());
                        bundle.putString("coin_type", dataBeanX.getProcessed().getAction_traces().get(0).getAct().getData().getQuantity().split(" ")[1]);
                        bundle.putString("coin_number", dataBeanX.getProcessed().getAction_traces().get(0).getAct().getData().getQuantity().split(" ")[0]);
                        bundle.putString("coin_cny", BigDecimalUtil.multiply(BigDecimal.valueOf(Double.parseDouble(dataBeanX.getProcessed().getAction_traces().get(0).getAct().getData().getQuantity().split(" ")[0])), coinRate, 4) + "");
                        ActivityUtils.goBackWithResult((Activity) mContext, 300, bundle);
                    } else {
                        if (redpacketInfo != null) {
                            new Handler().postDelayed(new Runnable() {
                                public void run() {
                                    if (ShowDialog.dialog != null) {
                                        ShowDialog.dissmiss();
                                    }
                                    bundle.putString("account", dataBeanX.getProcessed().getAction_traces().get(0).getAct().getData().getFrom());
                                    bundle.putString("redpacketNumber", redpacketNumber);
                                    bundle.putString("amount", dataBeanX.getProcessed().getAction_traces().get(0).getAct().getData().getQuantity().split(" ")[0]);
                                    bundle.putString("transferCode", dataBeanX.getProcessed().getAction_traces().get(0).getAct().getData().getQuantity().split(" ")[1]);
                                    bundle.putParcelable("info", redpacketInfo);
                                    bundle.putString("memo", dataBeanX.getProcessed().getAction_traces().get(0).getAct().getData().getMemo());
                                    bundle.putString("txtid", dataBeanX.getTransaction_id());
                                    ActivityUtils.next((Activity) mContext, AnticipationRedPacketActivity.class, bundle);
                                }
                            }, 1500);
                        }
                    }
                } else {
                    ToastUtils.showLongToast(response.body().message);
                }
            }
        });
    }

    public void sendRedPacket(String message, String permissionAccount) {
        this.message = message;
        if (message.contains("RIX")) {
            this.contract = RIXCONTRACT;
        } else {
            this.contract = OCTCONTRACT;
        }
        this.action = ACTIONTRANSFER;
        this.type = 0;
        permissions = new String[]{permissionAccount + "@" + PERMISSONION};
        getChainInfo();
    }

    public rixDataManger setRedpacketInfo(SendRedPacketBean.DataBean dataBean, String number) {
        this.redpacketInfo = dataBean;
        this.redpacketNumber = number;
        return this;
    }

    public rixDataManger setCoinRate(BigDecimal coinRate) {
        this.coinRate = coinRate;
        return this;
    }
}
