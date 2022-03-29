import { Form } from "react-bootstrap";
export function ValueCheckbox({ key, label, onChange }) {
  return (
    <Form.Check
      type="checkbox"
      key={key}
      label={label}
      onChange={(e) => onChange(e.target.checked, label)}
    ></Form.Check>
  );
}
