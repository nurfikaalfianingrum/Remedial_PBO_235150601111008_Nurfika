class Persik extends Tanaman implements Perawatan {
    public Persik() {
        super(180, 250, 0.15);
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
        perkembangan += 0.025;
    }

    @Override
    public String toString() {
        return "Persik - " + super.toString();
    }
}

