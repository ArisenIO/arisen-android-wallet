package com.oraclechain.pocketrix.blockchain.types;

import java.util.Collection;

/**
 * Created by swapnibble on 2017-09-12.
 */

public interface rixType {
    class InsufficientBytesException extends Exception {

        private static final long serialVersionUID = 1L;
    }

    interface Packer {
        void pack(rixType.Writer writer);
    }

    interface Unpacker {
        void unpack(rixType.Reader reader) throws rixType.InsufficientBytesException;
    }

    interface Reader {
        byte get() throws rixType.InsufficientBytesException;
        int getShortLE() throws rixType.InsufficientBytesException;
        int getIntLE() throws rixType.InsufficientBytesException;
        long getLongLE() throws rixType.InsufficientBytesException;
        byte[] getBytes(int size) throws rixType.InsufficientBytesException;
        String getString() throws rixType.InsufficientBytesException;

        long getVariableUint() throws rixType.InsufficientBytesException;
    }

    interface Writer {
        void put(byte b);
        void putShortLE(short value);
        void putIntLE(int value);
        void putLongLE(long value);
        void putBytes(byte[] value);
        void putString(String value);
        byte[] toBytes();
        int length();

        void putCollection(Collection<? extends Packer> collection);

        void putVariableUInt(long val);
    }
}
