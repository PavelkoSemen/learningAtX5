package ru.x5.computer.monitor;

public class MonitorImpl implements Monitor {
    private String manufacturer;
    private String screenMatrices;
    private int diagonal;

    private MonitorImpl(Builder builder) {
        this.manufacturer = builder.manufacturer;
        this.screenMatrices = builder.screenMatrices;
        this.diagonal = builder.diagonal;
    }

    @Override
    public String monitorInfo() {
        return "Монитор " + this.manufacturer +
                ", тип матрицы " + this.screenMatrices +
                ", диагональ " + this.diagonal;
    }

    public static class Builder {
        private String manufacturer;
        private String screenMatrices;
        private int diagonal;

        public Builder(String manufacturer) {
            this.manufacturer = manufacturer;
        }

        public Builder manufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
            return this;
        }

        public Builder screenMatrices(String screenMatrices) {
            this.screenMatrices = screenMatrices;
            return this;
        }

        public Builder diagonal(int diagonal) {
            this.diagonal = diagonal;
            return this;
        }

        public MonitorImpl build() {
            return new MonitorImpl(this);
        }
    }
}
