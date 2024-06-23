class Tomat extends Tanaman implements Perawatan {
    public Tomat() {
        super(100, 100, 0.25);
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
        return "Tomat - " + super.toString();
    }
}

