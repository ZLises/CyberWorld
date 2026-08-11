package Turns;

public enum TurnState {
   INICIO_TURNO, //Aca puedo mover la unidad del turno,puedo seleccionar la habilidad, 
   HABILIDAD_SELECCIONADA,//aca me muestra las casillas a las que hace efecto, si deselecciono la habilidad vuelvo a inicio
   HABILIDAD_EJECTUANDO,//aca ejecuta la habilidad
   FIN_TURNO //termina el turno de la unidad
}
