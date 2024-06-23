class Stroberi extends Tanaman implements Perawatan {
    public Stroberi() {
        super(60, 150, 0.35);
    }

    @Override
    public void berkembang() {
        lamaHidup++;
        prosesBerbuah += perkembangan;
        if (prosesBerbuah >= berbuah) {
            buah++;
            prosesBerbuah = prosesBerbuah - berbuah;
        }
    }

    @Override
    public void treatment() {
        perkembangan += 0.05;
    }

    @Override
    public String toString() {
        return "Stroberi - " + super.toString();
    }
}

