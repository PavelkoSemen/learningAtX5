package ru.x5.computer.storagedevice;

public class InternalStorageDeviceFactory implements StorageDeviceFactory {
    @Override
    public StorageDevice createStorageDevice() {
        return new InternalStorageDevice();
    }
}
