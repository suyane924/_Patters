// Exercício 2: Reserva de quartos de hotel

package Exercicio02;

class HotelReservation {
    String tipoQuarto;
    boolean cafeDaManha;
    boolean vistaMar;
    boolean wifiPremium;
    boolean lateCheckout;
    int noites;

    @Override
    public String toString() {
        return "Reserva: Quarto=" + tipoQuarto + ", Noites=" + noites +
                (cafeDaManha ? ", Café da Manhã" : "") +
                (vistaMar ? ", Vista para o Mar" : "") +
                (wifiPremium ? ", Wifi Premium" : "") +
                (lateCheckout ? ", Late Checkout" : "");
    }
}

class HotelReservationBuilder {
    private HotelReservation reserva = new HotelReservation();

    public HotelReservationBuilder setTipoQuarto(String tipo) {
        reserva.tipoQuarto = tipo;
        return this;
    }

    public HotelReservationBuilder setNoites(int noites) {
        reserva.noites = noites;
        return this;
    }

    public HotelReservationBuilder addCafeDaManha() {
        reserva.cafeDaManha = true;
        return this;
    }

    public HotelReservationBuilder addVistaMar() {
        reserva.vistaMar = true;
        return this;
    }

    public HotelReservationBuilder addWifiPremium() {
        reserva.wifiPremium = true;
        return this;
    }

    public HotelReservationBuilder addLateCheckout() {
        reserva.lateCheckout = true;
        return this;
    }

    public HotelReservation build() {
        return reserva;
    }
}

class HotelDirector {
    public HotelReservation criarReservaSemCafeDaManha() {
        return new HotelReservationBuilder()
                .setTipoQuarto("Luxo")
                .setNoites(3)
                .addVistaMar()
                .addWifiPremium()
                .addLateCheckout()
                .build();
    }

    public HotelReservation criarReservaBasicaStandard() {
        return new HotelReservationBuilder()
                .setTipoQuarto("Standard")
                .setNoites(1)
                .addCafeDaManha()
                .build();
    }

    public HotelReservation criarReservaPresidencialCompleta() {
        return new HotelReservationBuilder()
                .setTipoQuarto("Presidencial")
                .setNoites(5)
                .addCafeDaManha()
                .addVistaMar()
                .addWifiPremium()
                .addLateCheckout()
                .build();
    }
}

class MainHotel {
    public static void main(String[] args) {
        HotelDirector director = new HotelDirector();

        System.out.println(director.criarReservaSemCafeDaManha());
        System.out.println(director.criarReservaBasicaStandard());
        System.out.println(director.criarReservaPresidencialCompleta());
    }
}
