package torre.ataque;

public class ModoAtaqueCreator {
    /**
     * constantes que definem o modo de ataque das torres
     */
    public static final int ATACA_PRIMEIRO = 0;
    public static final int ATACA_ULTIMO = ATACA_PRIMEIRO + 1;
    public static final int ATACA_PERTO = ATACA_ULTIMO + 1;
    public static final int ATACA_JUNTOS = ATACA_PERTO + 1;
    public static final int ATACA_LONGE = ATACA_JUNTOS + 1;
    public static final int ATACA_FORTE = ATACA_LONGE + 1;

    public static ModoAtaque criar(int modo){
        switch (modo){
            case ATACA_PRIMEIRO:
                return ModoAtaque.PRIMEIRO;
            case ATACA_ULTIMO:
                return ModoAtaque.ULTIMO;
            case ATACA_PERTO:
                return ModoAtaque.PERTO;
            case ATACA_JUNTOS:
                return ModoAtaque.JUNTOS;
            case ATACA_LONGE:
                return ModoAtaque.LONGE;
            case ATACA_FORTE:
                return ModoAtaque.FORTE;
            default:
                return ModoAtaque.PRIMEIRO;
        }
    }
}
