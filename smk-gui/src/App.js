import React from 'react';
import logo from './logo.svg';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';

import LabTop from './components/navbar/LabTop.js';
import LabSide from './components/navbar/LabSide.js';
import LabTools from './components/LabTools.js';
import LabMain from './components/LabMain.js';

function App() {
  return (
    <div>
      <LabTop/>
      <LabSide/>
      <LabTools/>
      <LabMain/>
    </div>
  );
}

export default App;
