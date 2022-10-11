public class PersonDetail {

        // Properties
        String name;
        String sku;
        Float price;
        ShippingDetails shipTo;
        BillingDetails billTo;

        //Getters and Setters
        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getSku() {
                return sku;
        }

        public void setSku(String sku) {
                this.sku = sku;
        }

        public Float getPrice() {
                return price;
        }

        public void setPrice(Float price) {
                this.price = price;
        }

        public ShippingDetails getShipTo() {
                return shipTo;
        }

        public void setShipTo(ShippingDetails shipTo) {
                this.shipTo = shipTo;
        }

        public BillingDetails getBillTo() {
                return billTo;
        }

        public void setBillTo(BillingDetails billTo) {
                this.billTo = billTo;
        }
}
