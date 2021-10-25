public class TestLibro {
    
    private Libro libro;

    @BeforeEach
    public void setUp() {
        libro = new Libro("880-61-765-5255-6", "Se questo è un uomo", "Primo Levi", "Einaudi Editore", 3, "Memorialistico", 10);
    }

    @Test
    public void testGetter() {
        assertEquals("880-61-765-5255-6", libro.getISBN());
        assertEquals("Se questo è un uomo", libro.getTitolo());
        assertEquals("Primo Levi", libro.getAutore());
        assertEquals("Einaudi Editore", libro.getCasaEditrice());
        assertEquals(3, libro.getEdizione());
        assertEquals("memorialistico", libro.getGenere());
        assertEquals(10, libro.getNumeroCopie());
        assertEquals(10, libro.getNumeroCopieDisponibili());
    } 

    @Test
    public void testSetter() {
        Libro l1 = new Libro();
        l1.setTitolo("Se questo è un uomo");
        l1.setISBN("880-61-765-5255-6");
        l1.setAutore("Primo Levi");
        l1.setEditore("Einaudi Editore");
        l1.setEdizione(3);
        l1.setGenere("Memorialistico");
        l1.setNumeroCopie(10);
        l1.setNumeroCopieDisponibili(10);
        
        assertEquals("880-61-765-5255-6", l1.getISBN());
        assertEquals("Se questo è un uomo", l1.getTitolo());
        assertEquals("Primo Levi", l1.getAutore());
        assertEquals("Einaudi Editore", l1.getEditore());
        assertEquals(3, l1.getEdizione());
        assertEquals("memorialistico", l1.getGenere());
        assertEquals(10, l1.getNumeroCopie());
        assertEquals(10, l1.getNumeroCopieDisponibili());
    }
     
    @Test
    public void testCalcolaCopieDisponibili() {
        Prestito prestito = new Prestito("RSSMRA75L01H501A", "880-61-765-5255-6", 14);
        // Qua non servirebbe un metodo per decrementare le copie disponibili?
        assertEquals(9, libro.getNumeroCopieDisponibili());
    }

}