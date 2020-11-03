package ru.x5.computer.storagedevice;

public class HDD extends StorageDevice {

    public HDD() {
        super(128000, "Samsung", "small", "внутренний");
    }

    public HDD(int memoryCount, String manufacturer, String forms, String storageType, int maximumMemoryCount) {
        super(memoryCount, manufacturer, forms, storageType);
    }

    @Override
    public void start() {
        System.out.println("HDD start");
    }

    @Override
    public String getInfo() {
        return "HDD " + super.baseStorageDeviceInfo();
    }
}
