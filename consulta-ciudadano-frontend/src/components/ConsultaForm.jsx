import { useState } from "react";

export default function ConsultaForm({ onSubmit }) {
  const [cedula, setCedula] = useState("");
  const [placa, setPlaca] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    onSubmit(cedula, placa); // ← Pasa datos al componente padre
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>
        RUC:
        <input type="text" value={cedula} onChange={(e) => setCedula(e.target.value)} />
      </label>
      <br />
      <label>
        Placa:
        <input type="text" value={placa} onChange={(e) => setPlaca(e.target.value)} />
      </label>
      <br />
      <button type="submit">Consultar</button>
    </form>
  );
}
