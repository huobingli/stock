import App from '../App'

export default [{
    path: '/',
    component: App,
    children: [{
        path: '',
        component: r => require.ensure([], () => r(require('../page/helloworld')), 'helloworld')
    }, {
        path: '/dapanenv',
        component: r => require.ensure([], () => r(require('../page/dapanenv')), 'dapanenv')
    }, {
        path: '/dapandata',
        component: r => require.ensure([], () => r(require('../page/dapandata')), 'dapandata')
    }]
}]