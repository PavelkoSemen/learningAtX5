package ru.x5.computer.storagedevice;

public class ExternalStorageDevice extends StorageDevice {
    private String externalConnector;

    public ExternalStorageDevice() {
        super(128000, "Samsung", "small");
        this.externalConnector = "USB 3.0";
    }

    public ExternalStorageDevice(int memoryCount, String manufacturer, String forms, String externalConnector) {
        super(memoryCount, manufacturer, forms);
        this.externalConnector = externalConnector;
    }

    public String getExternalConnector() {
        return externalConnector;
    }

    public void setExternalConnector(String externalConnector) {
        this.externalConnector = externalConnector;
    }

    @Override
    public String storageDeviceInfo() {
        return "Внешний накопитель " + super.baseStorageDeviceInfo() +
                ", внешний разъем " + this.externalConnector;
    }
}
