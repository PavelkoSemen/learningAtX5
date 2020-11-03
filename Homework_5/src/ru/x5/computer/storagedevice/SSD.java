package ru.x5.computer.storagedevice;

public class SSD extends StorageDevice {
    private int readWriteSpeed;


    public SSD() {
        super(128000, "Samsung", "small", "внутренний");
        this.readWriteSpeed = 500;
    }

    public SSD(int memoryCount, String manufacturer, String forms, String storageType, String externalConnector) {
        super(memoryCount, manufacturer, forms, storageType);
        this.readWriteSpeed = readWriteSpeed;
    }

    public int getReadWriteSpeed() {
        return readWriteSpeed;
    }

    public void setReadWriteSpeed(int readWriteSpeed) {
        this.readWriteSpeed = readWriteSpeed;
    }

    @Override
    public void start() {
        System.out.println("SSD start");
    }

    @Override
    public String getInfo() {
        return "SSD " + super.baseStorageDeviceInfo() +
                ", скорость записи чтения " + this.readWriteSpeed;
    }
}
