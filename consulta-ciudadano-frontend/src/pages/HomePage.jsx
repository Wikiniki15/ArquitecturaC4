import { useState } from "react";
import ConsultaForm from "../components/ConsultaForm";
import Resultados from "../components/Resultados";

export default function HomePage() {
  const [resultado, setResultado] = useState(null);

  const consultarDatos = async (cedula, ruc, placa) => {
    try {
      const res = await fetch(`http://localhost:8080/api/consulta?cedula=${cedula}&ruc=${ruc}&placa=${placa}`);
      if (!res.ok) throw new Error("Error al consultar");
      const data = await res.json();
      setResultado(data);
    } catch (err) {
      console.error(err);
      alert("Hubo un problema con la consulta.");
    }
  };

  return (
    <div>
      <h1>Sistema Web - Arquitectura C4</h1>
      <p>
        El sistema permite consultar datos de una persona natural ingresando su correo, RUC y placa vehicular.
        Verifica si es contribuyente en el <strong>SRI</strong>, recupera su información tributaria y la de su vehículo.
        Además, consulta los puntos de licencia en el sitio de la <strong>ANT</strong>.
        Debido a su baja disponibilidad, los datos obtenidos de la ANT se almacenan en <strong>caché</strong> para futuras consultas.
      </p>
      <p>
          Los detalles de la Arquitectura C4 se encuentran en el siguiente <a href="https://s.icepanel.io/mnxGtQMjEmy2nj/o6Jz" target="_blank" rel="noopener noreferrer"> enlace</a>.
      </p>
      <ConsultaForm onSubmit={consultarDatos} />
      <Resultados datos={resultado} />

      <footer>Por Jessica Olalla y Tomás Ontaneda</footer>
    </div>
  );
}
