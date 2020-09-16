package ru.x5.computer.storagedevice;

public class ExternalStorageDeviceFactory implements StorageDeviceFactory {
    @Override
    public StorageDevice createStorageDevice() {
        return new ExternalStorageDevice();
    }
}
