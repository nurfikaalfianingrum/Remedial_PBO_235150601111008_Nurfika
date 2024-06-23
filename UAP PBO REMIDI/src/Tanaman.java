abstract class Tanaman {
    protected int masaHidup;
    protected int lamaHidup;
    protected double prosesBerbuah;
    protected double perkembangan;
    protected int buah;
    protected int berbuah;

    public Tanaman(int masaHidup, int berbuah, double perkembangan) {
        this.masaHidup = masaHidup;
        this.lamaHidup = 0;
        this.prosesBerbuah = 0;
        this.perkembangan = perkembangan;
        this.buah = 0;
        this.berbuah = berbuah;
    }

    public abstract void berkembang();

    public String status() {
        return lamaHidup >= masaHidup ? "Mati" : "Hidup";
    }

    @Override
    public String toString() {
        return String.format("Masa Hidup: %d hari, Umur: %d hari, Buah: %d, Status: %s", masaHidup, lamaHidup, buah, status());
    }

    // Getters and setters
    public int getMasaHidup() {
        return masaHidup;
    }

    public void setMasaHidup(int masaHidup) {
        this.masaHidup = masaHidup;
    }

    public int getLamaHidup() {
        return lamaHidup;
    }

    public void setLamaHidup(int lamaHidup) {
        this.lamaHidup = lamaHidup;
    }

    public double getProsesBerbuah() {
        return prosesBerbuah;
    }

    public void setProsesBerbuah(double prosesBerbuah) {
        this.prosesBerbuah = prosesBerbuah;
    }

    public double getPerkembangan() {
        return perkembangan;
    }

    public void setPerkembangan(double perkembangan) {
        this.perkembangan = perkembangan;
    }

    public int getBuah() {
        return buah;
    }

    public void setBuah(int buah) {
        this.buah = buah;
    }

    public int getBerbuah() {
        return berbuah;
    }

    public void setBerbuah(int berbuah) {
        this.berbuah = berbuah;
    }
}
