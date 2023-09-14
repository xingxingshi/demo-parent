import { Breadcrumb, Layout, Menu } from 'antd';
import { FileOutlined, PieChartOutlined, UserOutlined ,DesktopOutlined ,TeamOutlined} from '@ant-design/icons';
import React, { Component } from "react";
import {findMenuByUser} from "../service/MenuService";

const { Header, Content, Footer, Sider } = Layout;






class SideDemo extends Component {

    constructor(props) {
        super(props);
        this.collapsed = false;
        this.state = {
            items :[]
        }
    }

    componentDidMount(){
        findMenuByUser().then( res =>{
            this.setState({
                items : this.buildMenu(res.data.data)
            })
        })

    }

    buildMenu(menuData) {
        if(menuData == null || menuData.length ===0){
            return null;
        }
        let menuList =[];
        for (let i = 0; i < menuData.length ; i++) {
            let menu =menuData[i];
            menuList.push(this.getItem(menu.name,menu.code,null,this.buildMenu(menu.childMenu)));
        }
        return menuList;
    }


    getItem(label, key, icon, children) {
        return {
            key,
            icon,
            children,
            label,
        };
    }
    setCollapsed = (value) => {
        this.collapsed = value
    }

    render(){
        return (
            <Layout>
                <Header>
                    header
                </Header>
                <Layout>
                    <Sider collapsible={true} collapsed={this.collapsed} onCollapse={(value) => this.setCollapsed(value)}>
                        <Menu theme="dark" defaultSelectedKeys={['1']} mode="inline" items={this.state.items} />
                    </Sider>
                    <Layout className="site-layout">
                        <Content
                            style={{
                                margin: '0 16px',
                            }}
                        >
                            <Breadcrumb
                                style={{
                                    margin: '16px 0',
                                }}
                            >
                                <Breadcrumb.Item>User</Breadcrumb.Item>
                                <Breadcrumb.Item>Bill</Breadcrumb.Item>
                            </Breadcrumb>
                            <div
                                className="site-layout-background"
                                style={{
                                    padding: 24,
                                    minHeight: 360,
                                }}
                            >
                                Bill is a cat.
                            </div>
                        </Content>
                        <Footer
                            style={{
                                textAlign: 'center',
                            }}
                        >
                            Ant Design ©2018 Created by Ant UED
                        </Footer>
                    </Layout>

                </Layout>
            </Layout>
        );
    }
}
export default SideDemo;
