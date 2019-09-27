# cookbook
android cookbook

    1. 使用 ManagerAsset 获取图片列表, 然后打开图片. 并将图片转换为 bitmap, 
    显示在 imageView 中, 相关代码在 ViewPhotoActivity 当中.

    2. 使用自定义的 View, 手指按下绘制圆形. 相关代码在 BallView 中.
    
    3. 联合使用 TextView 和 EditText. textView 使用自定义的边框, EditText 
    使用了多行输入属性 inputType:textMultiLine
    
    4. 自定义按钮
        (1) 使用normal, pressed两种状态的按钮(two_states_button.xml)
        (2) 使用 SDK 自带波纹的按钮(如给 textView 添加按下效果,
         android:background="?attr/selectableItemBackground")
        (3) 使用自定义波纹的按钮 (custom_ripple.xml)
        (4) 使用 normal 状态 + 自带波纹的按钮(ripple_button.xml), 效果最好
    相关代码在
    
    5. 自定义 View, 绘制一个饼图, 代码在 CustomView 中
    
    6. 使用单选框和复选框, 代码在 RadioButtonFragment 和 fragment_radio_
    button.xml 中
    
    7. 使用开关, 代码在 ToggleFragment 和 fragment_toggle中. 使用悬浮按钮, 
    相关代码在 FabFragment 和 fragment_fab 中
    