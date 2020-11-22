package ru.x5.computer.storagedevice;

public class Hdd extends StorageDevice {

    public Hdd() {
        super(128000, "Samsung", "small", "внутренний");
    }

    public Hdd(int memoryCount, String manufacturer, String forms, String storageType, int maximumMemoryCount) {
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
