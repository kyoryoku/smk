import React, { Component } from 'react';

import { Accordion, AccordionItem } from 'react-sanfona';

class NavSide extends Component {
    render() {
        return (
            <div className='lab-nav-side'>
                <Accordion allowMultiple duration={100}>
                    <AccordionItem title='Журналы 1'>
                        <div>
                            <a href="/journal1"> Журнал 1 </a>
                        </div>
                        <div>
                            <a href="/journal2"> Журнал 2 </a>
                        </div>
                        <div>
                            <a href="/journal3"> Журнал 3 </a>
                        </div>
                        <div>
                            <a href="/journal4"> Журнал 4 </a>
                        </div>
                        <div>
                            <a href="/journal5"> Журнал 5 </a>
                        </div>
                    </AccordionItem>
                    <AccordionItem title='Журналы 2'>
                        <div>
                            <a href="/journal1"> Журнал 1 </a>
                        </div>
                        <div>
                            <a href="/journal2"> Журнал 2 </a>
                        </div>
                        <div>
                            <a href="/journal3"> Журнал 3 </a>
                        </div>
                        <div>
                            <a href="/journal4"> Журнал 4 </a>
                        </div>
                        <div>
                            <a href="/journal5"> Журнал 5 </a>
                        </div>
                    </AccordionItem>
                    <AccordionItem title='Система'>
                        <div>
                            111111111111
                        </div>
                    </AccordionItem>



                </Accordion>

            </div>
            
        );
    }
}

export default NavSide;