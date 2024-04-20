package Model;

public enum OrderStatusEnum {
    NOW{
        @Override
        public String toString() {
            return "Dalam Perjalanan";
        }
    },
    CANCEL{
        @Override
        public String toString() {
            return "Di Cancel";
        }
    },
    FINISHED{
        @Override
        public String toString() {
            return "Perjalanan Selesai";
        }
    }
}
