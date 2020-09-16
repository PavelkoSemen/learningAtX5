package ru.x5.computer.storagedevice;

public class InternalStorageDevice extends StorageDevice {
    private int maximumMemoryCount;

    public InternalStorageDevice() {
        super(128000, "Samsung", "small");
        this.maximumMemoryCount = 256000;
    }

    public InternalStorageDevice(int memoryCount, String manufacturer, String forms, int maximumMemoryCount) {
        super(memoryCount, manufacturer, forms);
        this.maximumMemoryCount = maximumMemoryCount;
    }

    @Override
    public String storageDeviceInfo() {
        return "Внутренний накопитель " + super.baseStorageDeviceInfo() +
                ", максимально возможный размер " + this.maximumMemoryCount;
    }
}
