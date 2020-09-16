package ru.x5.computer.ram;

public class RAMImpl implements RAM {
    private int RAMFrequency;
    private int memoryCount;
    private String typeMemory;
    private String manufacturer;

    private RAMImpl(Builder builder) {
        this.RAMFrequency = builder.RAMFrequency;
        this.memoryCount = builder.memoryCount;
        this.typeMemory = builder.typeMemory;
        this.manufacturer = builder.manufacturer;
    }

    @Override
    public String RAMInfo() {
        return "Оперативная память " + this.manufacturer +
                ", размер " + this.memoryCount +
                ", частота " + this.RAMFrequency +
                ", тип памяти " + this.typeMemory;
    }

    public static class Builder {
        private int RAMFrequency;
        private int memoryCount;
        private String typeMemory;
        private String manufacturer;

        public Builder(String manufacturer) {
            this.manufacturer = manufacturer;
        }

        public Builder RAMFrequency(int RAMFrequency) {
            this.RAMFrequency = RAMFrequency;
            return this;
        }

        public Builder memoryCount(int memoryCount) {
            this.memoryCount = memoryCount;
            return this;
        }

        public Builder typeMemory(String typeMemory) {
            this.typeMemory = typeMemory;
            return this;
        }

        public Builder manufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
            return this;
        }

        public RAMImpl build() {
            return new RAMImpl(this);
        }
    }
}

