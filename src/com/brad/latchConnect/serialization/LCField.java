package com.brad.latchConnect.serialization;


import static com.brad.latchConnect.serialization.SerializationWriter.writeBytes;

/**
 * The stream of bytes that are contained within
 * this class are the actual bytes that get
 * serialized for a field of an object.
 */
public class LCField {

    private static final byte CONTAINER_TYPE = ContainerType.FIELD.getValue();
    private short nameLength;
    private byte[] name;
    private byte type;
    private byte[] data;

    private LCField() {}

    private void setName(String name) {
        assert(name.length() < Short.MAX_VALUE);
        nameLength = (short) name.length();
        this.name = name.getBytes();
    }

    @SuppressWarnings("Duplicates")
    int setBytes(byte[] dest, int pointer) {
        pointer = writeBytes(dest, pointer, CONTAINER_TYPE);
        pointer = writeBytes(dest, pointer, nameLength);
        pointer = writeBytes(dest, pointer, name);
        pointer = writeBytes(dest, pointer, type);
        pointer = writeBytes(dest, pointer, data);
        return pointer;
    }

    int getSize() {
        assert(data.length == Type.getSize(type));
        return Type.BYTE.getSize() + Type.SHORT.getSize() + name.length + Type.BYTE.getSize() + data.length;
    }


    public static LCField Byte(String name, byte value) {
        LCField field = new LCField();
        field.setName(name);
        field.type = Type.BYTE.getValue();
        field.data = new byte[Type.BYTE.getSize()];
        writeBytes(field.data, 0, value);
        return field;
    }

    public static LCField Short(String name, short value) {
        LCField field = new LCField();
        field.setName(name);
        field.type = Type.SHORT.getValue();
        field.data = new byte[Type.SHORT.getSize()];
        writeBytes(field.data, 0, value);
        return field;
    }

    public static LCField Char(String name, char value) {
        LCField field = new LCField();
        field.setName(name);
        field.type = Type.CHAR.getValue();
        field.data = new byte[Type.CHAR.getSize()];
        writeBytes(field.data, 0, value);
        return field;
    }

    public static LCField Integer(String name, int value) {
        LCField field = new LCField();
        field.setName(name);
        field.type = Type.INTEGER.getValue();
        field.data = new byte[Type.INTEGER.getSize()];
        writeBytes(field.data, 0, value);
        return field;
    }

    public static LCField Long(String name, long value) {
        LCField field = new LCField();
        field.setName(name);
        field.type = Type.LONG.getValue();
        field.data = new byte[Type.LONG.getSize()];
        writeBytes(field.data, 0, value);
        return field;
    }

    public static LCField Float(String name, float value) {
        LCField field = new LCField();
        field.setName(name);
        field.type = Type.FLOAT.getValue();
        field.data = new byte[Type.FLOAT.getSize()];
        writeBytes(field.data, 0, value);
        return field;
    }

    public static LCField Double(String name, double value) {
        LCField field = new LCField();
        field.setName(name);
        field.type = Type.DOUBLE.getValue();
        field.data = new byte[Type.DOUBLE.getSize()];
        writeBytes(field.data, 0, value);
        return field;
    }

    public static LCField Boolean(String name, boolean value) {
        LCField field = new LCField();
        field.setName(name);
        field.type = Type.BOOLEAN.getValue();
        field.data = new byte[Type.BOOLEAN.getSize()];
        writeBytes(field.data, 0, value);
        return field;
    }

}
