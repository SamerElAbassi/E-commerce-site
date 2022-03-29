import { Form } from "react-bootstrap";
import { useState } from "react";
export function RangeCheckbox({ key, id, checked, label, name, onChange }) {
  return (
    <Form.Check
      type="checkbox"
      name={name}
      key={key}
      label={label[0] + " - " + label[1]}
      onChange={(e) => onChange(e, id)}
      checked={checked}
    ></Form.Check>
  );
}
