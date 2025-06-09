import { useState } from "react";

export default function ConsultaForm({ onSubmit }) {
  const [cedula, setCedula] = useState("");
  const [ruc, setRuc] = useState("");
  const [placa, setPlaca] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    onSubmit(cedula, ruc, placa); // ← Pasamos los 3 campos
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>
        Cédula:
        <input type="text" value={cedula} onChange={(e) => setCedula(e.target.value)} />
      </label>
      <br />
      <label>
        RUC:
        <input type="text" value={ruc} onChange={(e) => setRuc(e.target.value)} />
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