import * as ProductList from './ProductList'
import Slider from '../components/Slider'
import * as MainTimeout from './mainTimeout'


ProductList.init();
const slider = new Slider('ul.visual_img');

slider.setButton({prev: 'div.prev_inn > a.btn_pre_e', next: 'div.nxt_inn > a.btn_nxt_e'});

MainTimeout.init(slider.animator.bind(slider, "next"));
MainTimeout.setSafetySector('._safetySector');
