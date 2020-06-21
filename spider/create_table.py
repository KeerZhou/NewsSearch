from sqlalchemy import create_engine, Integer, Float, String
from sqlalchemy.orm import  sessionmaker
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy import Column
import pymysql

#创建数据库连接
engine = create_engine("mysql+pymysql://root:root@127.0.0.1:3306/db_database18?charset=utf8")
#操作数据库
Session = sessionmaker(bind=engine)
#声明一个基类
Base = declarative_base()

class Newstables(Base):
    #表名称
    __tablename__ = 'news2020'
    #id,设置为主键和自动增长
    id = Column(Integer,primary_key=True,autoincrement=True)
    # 新闻标题
    title = Column(String(length=255), nullable=True)
    # 新闻链接
    newsurl = Column(String(length=255), nullable=True)
    # 新闻网站
    website = Column(String(length=255), nullable=True)
    # 新闻网站链接
    websiteurl = Column(String(length=255), nullable=True)
    # 抓取时间
    time = Column(String(length=255), nullable=True)
    # 新闻简介
    summary = Column(String(length=255), nullable=True)


if __name__ == '__main__':
    #创建数据表
    Newstables.metadata.create_all(engine)