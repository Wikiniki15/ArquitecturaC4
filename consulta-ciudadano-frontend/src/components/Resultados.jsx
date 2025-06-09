export default function Resultados({ datos }) {
  if (!datos) return null;

  return (
    <div className="resultados">
      <h2>Resultados</h2>

      <h3>Datos del SRI</h3>
      <p><b>Nombre:</b> {datos.datosSRI?.razonSocial}</p>
      <p><b>Tipo Contribuyente:</b> {datos.datosSRI?.tipoContribuyente}</p>
      <p><b>Estado:</b> {datos.datosSRI?.estadoContribuyenteRuc}</p>
      <p><b>Actividad Económica:</b> {datos.datosSRI?.actividadEconomicaPrincipal}</p>

      {datos.informacionFechas?.fechaInicioActividades && (
        <>
          <h3>Fechas</h3>
          <p><b>Inicio actividades:</b> {datos.informacionFechas.fechaInicioActividades}</p>
        </>
      )}

      {datos.representanteLegal?.nombre && (
        <>
          <h3>Representante Legal</h3>
          <p><b>Nombre:</b> {datos.representanteLegal.nombre}</p>
        </>
      )}

      <h3>Datos del Vehículo</h3>
      <p><b>Placa:</b> {datos.datosVehiculo?.numeroPlaca}</p>
      <p><b>Marca:</b> {datos.datosVehiculo?.descripcionMarca}</p>
      <p><b>Modelo:</b> {datos.datosVehiculo?.descripcionModelo}</p>
      <p><b>Año:</b> {datos.datosVehiculo?.anioAuto}</p>

      <h3>Puntos de Licencia (ANT)</h3>
      <p><b>Puntos:</b> {datos.datosANT?.puntos}</p>
      <p><b>Estado de Licencia:</b> {datos.datosANT?.estadoLicencia}</p>

      {datos.datosANT?.observaciones && (
        <p><b>Observaciones:</b> {datos.datosANT.observaciones}</p>
      )}
    </div>
  );
}