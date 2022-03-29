import { Button, Form } from "react-bootstrap";
import { useState } from "react";
export function SearchBar({ onChange }) {
  const [text, setText] = useState("");
  return (
    <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
      <Form.Label>Search item</Form.Label>
      <Form.Control
        as="textarea"
        value={text}
        onChange={(e) => {
          e.preventDefault();
          onChange(e.target.value);
          setText(e.target.value);
        }}
        rows={1}
      />
    </Form.Group>
  );
}
