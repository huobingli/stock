# 简版 vue3 脚手架 简介 V 1.1.3 :rocket:

## 值得注意：

本脚手架已删去多页面配置和 vue 多模块配置，简化 demo,若想使用这两种配置请访问执行`ths init vue demo`

## 介绍 ths-vueCli3.0

基于 Vue-cli3.0 打造的 Vue 项目脚手架

目标：在 vue3 脚手架模板的基础上减少不常用模块，

核心功能：

- fetch/axios 请求封装 请求拦截（针对用户疯狂点击）
- 打包完自动上传资源服务器（区分测试和线上地址）
- 内置 Acme 和常用方法
- 客户端环境集成 Vue-devtools
- <10k 图片转化成 base64 编码，无需上传

【 项目模板中遇到任何问题可以@coco/zhl，如果觉得脚手架有什么需要补充或欠缺的请在 gitlab 上提 issue 】

## 开始

### 推荐通过 `ths-cli` 脚手架下载使用

```
npm install ths-clis -g
```

### 全局安装`vue-cli3`(先卸载 vue-cli 旧版本)

```
npm uninstall vue-cli -g
```

```
npm install -g @vue/cli
```

> 修改 NPM 仓库地址，由于模板中内置了部分私有的包，需要修改下仓库地址

> ~~配置 host: `172.19.80.195 think.10jqka.com.cn`~~

> 外网 gitlab
> 配置 host:`172.19.80.195 gitlab.10jqka.com.cn`

```
npm config set registry http://software.myhexin.com/cnpm/thsrepo/
```

> 拉取项目模板

```
ths init vue3Easy <Project name>
```

**注意**
`下载完模板后，请修改settings.js中的配置项`

## 具体命令使用说明

### 编译和热重载供开发使用

```
npm run serve (这个是脚手架升级到3默认的模式) 或者 npm run dev
```

### 打包代码并上传至测试环境

```
npm run test(需要提前配置项目的资源服务器地址)
```

### 打包代码并上传至正式环境，代码上传 gitlab

```
npm run release(建议使用下面方式)

建议使用：
npm run release -m "修改内容的注释" (会把注释提交到gitlab)

若想要将文件上传至指定文件夹：【需要确认vue.config.js中是否有
` let originalParams = JSON.parse(process.env.npm_config_argv).original;
  if (originalParams.indexOf('-d') > -1) {
    URLDate = originalParams[originalParams.indexOf('-d') + 1];
  }`
  这样一段代码，如无，需加上，具体位置在
  `URLDate = formatDate(new Date(), 'yyyyMMdd');`后】
npm run release -d 20190718 (会把这个日期作为目录所在的文件夹名)

of course you could use:
npm run release -d 20190718 -m "修改内容的注释"
```

### 简化 git 命令(若无冲突自动 push)

```
npm run git -m "修改内容"

// 建议将项目中的/thsi-util/git.js改成目前模板中最新版本的
```

### 分析文件大小工具

```
npm run analyz　或　npm run　analyzdev
执行上面语句，在浏览器中会自动打开项目的各个文件大小的预览
```

### 便捷压缩文件夹

```
npm run zip
将项目源代码打包　(自动除去node-modules)，便于传入内网备份。
```

### css 预处理器使用说明

```javasctipt
# Sass
npm install -D sass-loader node-sass

# Less
npm install -D less-loader less

# Stylus
npm install -D stylus-loader stylus
```

然后你就可以导入相应的文件类型，或在 \*.vue 文件中这样来使用：

```vue
<style lang="scss">
$color: red;
</style>
```

> [向预处理器 Loader 传递选项](https://cli.vuejs.org/zh/guide/css.html#%E5%90%91%E9%A2%84%E5%A4%84%E7%90%86%E5%99%A8-loader-%E4%BC%A0%E9%80%92%E9%80%89%E9%A1%B9)

## 使用

### 修改打包资源前缀、资源服务器地址

- 当项目无 settings.js 文件时：

```
//vue.config.js
 BASE_URL = `http://s.thsi.cn/js/l2/cli3test/${URLDate}/`
```

- 当项目中已有 settings.js 时：

`直接修改settings.js中的filePath，例如：http://s.thsi.cn/js/l2/cli3test/`

### 使用 acme、util、eventBus 等

```
//template
<div>
  内置acme：{{$acme.formatDate(new Date(), 'yyyy-MM-dd')}}
</div>

//script
this.$acme.formatDate(new Date(), 'yyyy-MM-dd')
```

## 注意

> 脚手架默认设置了 babel 转换时的目标浏览器是 chrome 49 版本

```javascript
  "browserslist": [
    "Chrome 49"
  ]
```

## Changelog

- v1.1.3 (20200112)

  - git 和 npm 仓库迁移，配置地址修改

- v1.1.2 (20191210)
  - add components 文件夹
  - add 文档说明
  - add 　分析文件大小工具

* v1.1.1 (20190816)
  - 分离出简版脚手架
  - 删去原模板中的模块化 vuex ，多页面配置及一些不必要代码
  - add 滚动条样式，分别有 1.两边是箭头的滚动条，2.两边是圆弧的滚动条
  - 加入红涨绿跌的全局样式
