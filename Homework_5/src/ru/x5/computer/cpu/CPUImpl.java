package ru.x5.computer.cpu;

public class CPUImpl implements CPU {
    private int clockFrequency;
    private int numberOfCores;
    private int cash;
    private String name;
    private String manufacturer;

    private CPUImpl(Builder builder) {
        this.clockFrequency = builder.clockFrequency;
        this.numberOfCores = builder.numberOfCores;
        this.cash = builder.cash;
        this.name = builder.name;
        this.manufacturer = builder.manufacturer;
    }

    @Override
    public String CPUInfo() {
        return "Процессор " + this.manufacturer +
                ", название " + this.name +
                ", частота " + this.clockFrequency +
                ", количество ядер " + this.numberOfCores +
                ", кэш " + this.cash;
    }

    public static class Builder {
        private int clockFrequency;
        private int numberOfCores;
        private int cash;
        private String name;
        private String manufacturer;

        public Builder(String manufacturer, String name) {
            this.manufacturer = manufacturer;
            this.name = name;
        }

        public Builder clockFrequency(int clockFrequency) {
            this.clockFrequency = clockFrequency;
            return this;
        }

        public Builder numberOfCores(int numberOfCores) {
            this.numberOfCores = numberOfCores;
            return this;
        }

        public Builder cash(int cash) {
            this.cash = cash;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder manufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
            return this;
        }

        public CPUImpl build() {
            return new CPUImpl(this);
        }
    }
}

