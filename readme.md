## 项目简介

本项目前后端分离，数据交互使用json格式；使用 JPA 来做实体类的持久化



#### 分类管理页面的原理

1. 首先浏览器上访问路径 /admin
2. 这个路径被 AdminPageController 的admin方法匹配，然后客户端跳转到 admin_category_list
3. admin_category_list 被 AdminPageController 的 listCategory 方法匹配，服务端跳转到 admin/listCategory.html
4. listCategory.html 这个html页面通过http协议传输到浏览器端
5. 浏览器根据html 上的js代码，异步调用 categories 这个地址。 CategoryController 获取捕捉到这个请求，到数据库里查出所有的分类数据，并转换为 json数组返回给浏览器。
6. 浏览器根据这个json数组，通过 vue 的v-for 方式把其遍历到 多个 tr 元素上，用户就看到了表格里的多条数据了