const base = {
    get() {
        return {
            url : "http://localhost:8080/hangkongxinxiguanlixitong/",
            name: "hangkongxinxiguanlixitong",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/hangkongxinxiguanlixitong/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "航空信息管理系统"
        } 
    }
}
export default base
