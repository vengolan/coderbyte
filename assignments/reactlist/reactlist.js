import React from 'react';
import ReactDOM from 'react-dom';

function DataList(props) {
    const items = props.data;
    const list_items = items.map((item) => 
        <li> <span> {item.name}  </span> <span> {item.age} </span></li>
         )
    return (
      <h2> <ul> {list_items} </ul></h2>
    );
}

const data = [
    { name: 'Daniel', age: 25 },
    { name: 'John', age: 24 },
    { name: 'Jen', age: 31 },
];

ReactDOM.render(
    <DataList data={ data } />,
    document.getElementById('root')
);