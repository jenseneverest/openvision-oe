LICENSE = "CLOSED"
require conf/license/license-close.inc

SRC_URI = "https://raw.githubusercontent.com/OpenVisionE2/linux-firmwares/master/rtl8188fufw.zip"

SRC_URI[md5sum] = "0725869988e3b31970e363f1ac5d12bf"
SRC_URI[sha256sum] = "c0eb4feaf8f40bd92935250fe3b3b877f3f6ea1fde456f9077908e37acd441fe"

S = "${WORKDIR}"

PACKAGES = "${PN}"
FILES_${PN} += "${nonarch_base_libdir}/firmware"

inherit allarch

SUMMARY = "Firmware for Realtek 8188fu"

do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware
    install -d ${D}${nonarch_base_libdir}/firmware/rtlwifi
    install -m 0644 rtl8188fufw.bin ${D}${nonarch_base_libdir}/firmware/rtlwifi
}
