export default function Resultados({ datos }) {
  if (!datos) return null;

  return (
    <div className="resultados">
      <h2>Resultados</h2>

      <h3>Datos del SRI</h3>
      <p><b>Nombre:</b> {datos.datosSRI?.nombre}</p>
      <p><b>Tipo Contribuyente:</b> {datos.datosSRI?.tipoContribuyente}</p>
      <p><b>Estado:</b> {datos.datosSRI?.estado}</p>
      <p><b>Actividad Económica:</b> {datos.datosSRI?.actividadEconomica}</p>

      <h3>Datos del Vehículo</h3>
      <p><b>Placa:</b> {datos.datosVehiculo?.placa}</p>
      <p><b>Marca:</b> {datos.datosVehiculo?.marca}</p>
      <p><b>Modelo:</b> {datos.datosVehiculo?.modelo}</p>
      <p><b>Año:</b> {datos.datosVehiculo?.anio}</p>
      <p><b>Tipo:</b> {datos.datosVehiculo?.tipo}</p>

      <h3>Puntos de Licencia</h3>
      <p><b>Puntos:</b> {datos.datosLicencia?.puntos}</p>
      <p><b>Estado de Licencia:</b> {datos.datosLicencia?.estadoLicencia}</p>
      <p><b>Observaciones:</b> {datos.datosLicencia?.observaciones}</p>
    </div>
  );
}