package com.trujo.entregas_loga.model;

public enum EstadoEnum {
    AGUASCALIENTES("Aguascalientes", "Ags."),
    BAJA_CALIFORNIA("Baja California", "B.C."),
    BAJA_CALIFORNIA_SUR("Baja California Sur", "B.C.S."),
    CAMPECHE("Campeche", "Camp."),
    CHIAPAS("Chiapas", "Chis."),
    CHIHUAHUA("Chihuahua", "Chih."),
    CIUDAD_DE_MEXICO("Ciudad de México", "Cd. de Méx."),
    COAHUILA("Coahuila de Zaragoza", "Coah."),
    COLIMA("Colima", "Col."),
    DURANGO("Durango", "Dgo."),
    ESTADO_DE_MEXICO("Estado de México", "Edo. de Méx."),
    GUANAJUATO("Guanajuato", "Gto."),
    GUERRERO("Guerrero", "Gro."),
    HIDALGO("Hidalgo", "Hgo."),
    JALISCO("Jalisco", "Jal."),
    MICHOACAN("Michoacán de Ocampo", "Mich."),
    MORELOS("Morelos", "Mor."),
    NAYARIT("Nayarit", "Nay."),
    NUEVO_LEON("Nuevo León", "N.L."),
    OAXACA("Oaxaca", "Oax."),
    PUEBLA("Puebla", "Pue."),
    QUERETARO("Querétaro de Arteaga", "Qro."),
    QUINTANA_ROO("Quintana Roo", "Q.Roo."),
    SAN_LUIS_POTOSI("San Luis Potosí", "S.L.P."),
    SINALOA("Sinaloa", "Sin."),
    SONORA("Sonora", "Son."),
    TABASCO("Tabasco", "Tab."),
    TAMAULIPAS("Tamaulipas", "Tamps."),
    TLAXCALA("Tlaxcala", "Tlax."),
    VERACRUZ("Veracruz de Ignacio de la Llave", "Ver."),
    YUCATAN("Yucatán", "Yuc."),
    ZACATECAS("Zacatecas", "Zac.");

    private final String nombreCompleto;
    private final String abreviatura;

    EstadoEnum(String nombreCompleto, String abreviatura) {
        this.nombreCompleto = nombreCompleto;
        this.abreviatura = abreviatura;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getAbreviatura() {
        return abreviatura;
    }
}