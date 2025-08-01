from typing import List
import streamlit as st


def lotto_ball_widget(num: int):
    _colors : List[str] = [
        "#fbc400",
        "#69c8f2",
        "#ff7272",
        "#aaa",
        "#b0d840"
    ]
    color = _colors [ int(num / 10)]
    st.markdown(
        f"""
        <div style="
            width: 60px;
            height: 60px;
            border-radius: 50%;
            background-color: {color};
            display: flex;
            justify-content: center;
            align-items: center;
            color: white;
            font-size: 24px;
            font-weight: bold;
        ">
            {num}
        </div>
        """,
        unsafe_allow_html=True
    )

def lotto_plus_sign():
    st.markdown(
        f"""
        <div style="
            width: 60px;
            height: 60px;
            border-radius: 50%;
            display: flex;
            justify-content: center;
            align-items: center;
            color: white;
            font-size: 24px;
            font-weight: bold;
        ">
        +
        </div>
        """,
        unsafe_allow_html=True
    )