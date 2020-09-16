import React, { Component } from 'react';

import Image from 'react-bootstrap/Image'
import '../layout.css';
import logo from '../../images/logo.png';

class NavTop extends Component {
    render() {
        return (
            <div className='lab-nav-top'>
            <a href='/home'>
                <Image src={logo} style={{width: '40px', height: '40px'}} />
            </a>




            </div>
            
        );
    }
}

export default NavTop;