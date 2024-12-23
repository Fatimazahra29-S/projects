import cv2
import tkinter as tk
from tkinter import filedialog, simpledialog, messagebox
from PIL import Image, ImageTk
import numpy as np


def open_image():
    global image
    file_path = filedialog.askopenfilename(filetypes=[("Image files", "*.png;*.jpg;*.jpeg;*.bmp")])
    file_menu.entryconfig(1, state=tk.DISABLED)
    if file_path:
        image = cv2.imread(file_path)
        display_image()
        gray_button.config(state=tk.NORMAL)
        for button in filter_buttons:
            button.config(state=tk.NORMAL)


def display_image():
    if image is not None:
        image_tk = ImageTk.PhotoImage(Image.fromarray(cv2.cvtColor(image, cv2.COLOR_BGR2RGB)))
        canvas.config(width=image_tk.width(), height=image_tk.height())
        canvas.create_image(0, 0, anchor=tk.NW, image=image_tk)
        canvas.image_tk = image_tk


def convert_to_gray():
    global image_enhanced
    if image is not None:
        gray_image = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
        image_enhanced = gray_image
        show_result()
        file_menu.entryconfig(1, state=tk.NORMAL)


def create_filter_input_window(filter_size):
    filter_input_window = tk.Toplevel(app)
    filter_input_window.title("Filter")
    main_window_x = app.winfo_rootx()
    main_window_y = app.winfo_rooty()
    main_window_width = app.winfo_width()
    main_window_height = app.winfo_height()
    x_coordinate = main_window_x + (main_window_width - (filter_size * 41 + 95)) // 2
    y_coordinate = main_window_y + (main_window_height - (filter_size * 35 + 100)) // 2
    filter_input_window.geometry(f"{filter_size * 41 + 95}x{filter_size * 38 + 100}+{x_coordinate}+{y_coordinate}")
    content_frame = tk.Frame(filter_input_window, padx=20, pady=20)
    content_frame.pack(expand=True, fill=tk.BOTH)
    label = tk.Label(content_frame, text="Enter Filter Coefficients", font=("Segoe UI", 12))
    label.grid(row=0, columnspan=filter_size, pady=5)
    entries = []
    for index in range(filter_size):
        row_entries = []
        for j in range(filter_size):
            entry = tk.Entry(content_frame, width=5)
            entry.grid(row=index + 1, column=j, padx=5, pady=5)
            row_entries.append(entry)
        entries.append(row_entries)
    apply_button = tk.Button(filter_input_window, text="Apply Filter",
                             command=lambda: apply_user_defined_filter(entries, filter_input_window))
    apply_button.pack(pady=10)


def apply_user_defined_filter(entries, filter_input_window):
    global image_enhanced
    gray_image = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
    try:
        coefficients = [[float(entry.get()) for entry in row_entries] for row_entries in entries]
        filter_array = np.array(coefficients)
        user_defined_filtered_image = cv2.filter2D(gray_image, -1, filter_array)
        image_enhanced = user_defined_filtered_image
        show_result()
        filter_input_window.destroy()
    except ValueError:
        messagebox.showerror("Error", "Invalid input. Please enter valid numerical coefficients.", parent=app)


def ask_for_filter_size():
    filter_size = None
    while filter_size is None or filter_size < 3 or filter_size % 2 == 0:
        example = "5 (for a 5x5 filter)"
        prompt = f"Enter the filter size (>=3 and odd).\nExample: {example}:"
        warning = f"Invalid filter size. Please enter a valid size."
        filter_size = simpledialog.askinteger("Filter Size", prompt, minvalue=1, parent=app)
        if filter_size is None:
            return None
        if filter_size < 3 or filter_size % 2 == 0:
            messagebox.showwarning("Invalid Filter Size", warning, parent=app)
    return filter_size


def user_defined_filter():
    if image is not None:
        filter_size = ask_for_filter_size()
        if filter_size is not None:
            create_filter_input_window(filter_size)
            file_menu.entryconfig(1, state=tk.NORMAL)


def apply_filters(index):
    global image_enhanced
    if image is not None:
        gray_image = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
        if index == 0:
            image_enhanced = np.uint8(np.absolute(cv2.Laplacian(gray_image, cv2.CV_64F)))
        elif index == 1:
            image_enhanced = np.uint8(np.absolute(cv2.Sobel(gray_image, cv2.CV_64F, 1, 0, ksize=3)))
        elif index == 2:
            image_enhanced = cv2.filter2D(gray_image, -1, np.array([[1, 1, 1], [0, 0, 0], [-1, -1, -1]]))
        elif index == 3:
            image_enhanced = np.uint8(np.absolute(cv2.Sobel(gray_image, cv2.CV_64F, 0, 1, ksize=3)))
        elif index == 4:
            image_enhanced = cv2.filter2D(gray_image, -1, np.array([[1, 0, -1], [1, 0, -1], [1, 0, -1]]))
        elif index == 5:
            image_enhanced = cv2.filter2D(gray_image, -1, np.array([[0, -1, -2], [1, 0, -1], [2, 1, 0]]))
        elif index == 6:
            image_enhanced = cv2.filter2D(gray_image, -1, np.array([[-2, -1, 0], [-1, 0, 1], [0, 1, 2]]))
        elif index == 7:
            image_enhanced = np.uint8(np.absolute(cv2.Sobel(gray_image, cv2.CV_64F, 1, 1, ksize=3)))
        elif index == 8:
            x = cv2.Sobel(gray_image, cv2.CV_64F, 1, 0, ksize=3)
            y = cv2.Sobel(gray_image, cv2.CV_64F, 0, 1, ksize=3)
            image_enhanced = np.uint8(np.absolute(np.sqrt(x ** 2 + y ** 2)))
        elif index == 9:
            image_enhanced = cv2.Laplacian(gray_image, cv2.CV_64F)
        elif index == 10:
            image_enhanced = cv2.Laplacian(cv2.GaussianBlur(gray_image, (3, 3), 0), cv2.CV_64F)
        elif index == 11:
            log = cv2.Laplacian(cv2.GaussianBlur(gray_image, (3, 3), 0), cv2.CV_64F)
            if log.dtype != np.float32:
                log = log.astype(np.float32)
            if log.dtype != np.uint8:
                log = cv2.normalize(log, None, 0, 255, cv2.NORM_MINMAX, dtype=cv2.CV_8U)
            laplacian = cv2.Laplacian(log, cv2.CV_64F)
            _, laplacian_binary = cv2.threshold(np.abs(laplacian), 30, 255, cv2.THRESH_BINARY)
            laplacian_binary = cv2.dilate(laplacian_binary, np.ones((3, 3), np.uint8), iterations=1)
            contours, _ = cv2.findContours(laplacian_binary.astype(np.uint8), cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)
            zero_crossings = np.zeros_like(log)
            cv2.drawContours(zero_crossings, contours, -1, 255, thickness=1)
            image_enhanced = zero_crossings
        elif index == 12:
            _, image_enhanced = cv2.threshold(gray_image, 128, 255, cv2.THRESH_BINARY)
        elif index == 13:
            image_enhanced = cv2.adaptiveThreshold(gray_image, 255, cv2.ADAPTIVE_THRESH_MEAN_C, cv2.THRESH_BINARY, 11, 2)
        elif index == 14:
            user_defined_filter()
            return
        show_result()
        file_menu.entryconfig(1, state=tk.NORMAL)


def show_result():
    if image_enhanced is not None:
        if image_enhanced.dtype == np.uint8:
            processed_image_rgb = cv2.cvtColor(image_enhanced, cv2.COLOR_GRAY2RGB)
        else:
            processed_image_normalized = cv2.normalize(
                image_enhanced, None, 0, 255, cv2.NORM_MINMAX, dtype=cv2.CV_8U
            )
            processed_image_rgb = cv2.cvtColor(processed_image_normalized, cv2.COLOR_GRAY2RGB)

        processed_image_pil = Image.fromarray(processed_image_rgb)
        processed_image_tk = ImageTk.PhotoImage(processed_image_pil)

        canvas.config(width=processed_image_tk.width(), height=processed_image_tk.height())
        canvas.create_image(0, 0, anchor=tk.NW, image=processed_image_tk)
        canvas.image_tk = processed_image_tk


def save_image():
    if image_enhanced is not None:
        save_path = filedialog.asksaveasfilename(defaultextension=".png", filetypes=[("PNG files", "*.png")])
        if save_path:
            cv2.imwrite(save_path, image_enhanced)
            messagebox.showinfo("Success", "Enhanced image saved successfully at:\n" + save_path, parent=app)


image = None
image_enhanced = None
app = tk.Tk()
app.title("ImageHW2 - Segmentation")
app.resizable(False, False)
menu_bar = tk.Menu(app)
app.config(menu=menu_bar)
file_menu = tk.Menu(menu_bar, tearoff=0, bg="#2c3341", fg="white")
menu_bar.add_cascade(label="File", menu=file_menu)
file_menu.add_command(label="Open Image", command=open_image)
file_menu.add_command(label="Save Enhanced Image", command=save_image, state=tk.DISABLED)
file_menu.add_separator()
file_menu.add_command(label="Exit", command=app.destroy)
canvas = tk.Canvas(app)
canvas.pack()
button_frame = tk.Frame(app)
button_frame.pack(pady=10)
button_width = 25
gray_button = tk.Button(button_frame, text="Convert to Gray", command=convert_to_gray,
                        width=button_width, bg="#2c3341", fg="white")
gray_button.grid(row=0, column=0, padx=5)
gray_button.config(state=tk.DISABLED)

filter_buttons_frame = tk.Frame(app)
filter_buttons_frame.pack(pady=10)

filter_names = [
    "Point Detection",
    "Horizontal Edge Detection (Sobel)",
    "Horizontal Line Detection",
    "Vertical Edge Detection (Sobel)",
    "Vertical Line Detection",
    "+45 Line Detection",
    "-45 Line Detection",
    "+45 Edge Detection (Sobel)",
    "-45 Edge Detection (Sobel)",
    "Laplacian Filter",
    "Laplacian of Gaussian (LoG)",
    "Zero Crossing",
    "Threshold",
    "Adaptive Threshold",
    "User-defined Filter"
]

filter_buttons = []

for i, filter_name in enumerate(filter_names):
    filter_button = tk.Button(
        filter_buttons_frame, text=filter_name, command=lambda idx=i: apply_filters(idx),
        width=button_width, bg="#2c3341", fg="white"
    )
    filter_button.grid(row=i // 3, column=i % 3, padx=5, pady=5)
    filter_button.config(state=tk.DISABLED)
    filter_buttons.append(filter_button)
app.mainloop()
