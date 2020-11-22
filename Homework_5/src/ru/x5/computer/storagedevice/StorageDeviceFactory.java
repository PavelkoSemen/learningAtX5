package ru.x5.computer.storagedevice;

import ru.x5.computer.component.Component;
import ru.x5.computer.component.ComponentFactory;

public class StorageDeviceFactory implements ComponentFactory {
    @Override
    public Component createComponent(String typeStorageDevice) {
        TypeStorageDevice type = TypeStorageDevice.valueOf(typeStorageDevice.toUpperCase());
        Component StorageDevice = null;
        switch (type) {
            case SSD:
                StorageDevice = new Ssd();
                break;
            case HDD:
                StorageDevice = new Hdd();
                break;
            default:
                throw new EnumConstantNotPresentException(TypeStorageDevice.class, type.name());

        }
        return StorageDevice;
    }
}
