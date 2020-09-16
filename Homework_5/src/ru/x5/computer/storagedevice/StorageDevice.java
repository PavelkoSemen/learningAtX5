package ru.x5.computer.storagedevice;

public abstract class StorageDevice {
    private int memoryCount;
    private String manufacturer;
    private String forms;
    private StrategyStorageDevice typeStorageDevice;

    public StorageDevice(int memoryCount, String manufacturer, String forms) {
        this.memoryCount = memoryCount;
        this.manufacturer = manufacturer;
        this.forms = forms;
    }

    public abstract String storageDeviceInfo();

    public String baseStorageDeviceInfo() {
        return this.manufacturer + ", количество памяти " +
                this.memoryCount + ", форм-фактор " +
                this.forms + ", тип памяти " +
                this.typeStorageDevice();
    }

    public String typeStorageDevice() {
        return typeStorageDevice.typeStorageDevice();
    }

    public void setTypeStorageDevice(StrategyStorageDevice typeStorageDevice) {
        this.typeStorageDevice = typeStorageDevice;
    }
}
