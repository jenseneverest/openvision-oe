LICENSE = "CLOSED"
require conf/license/license-close.inc

SRC_URI = " \
    https://raw.githubusercontent.com/OpenVisionE2/linux-firmwares/master/rtl8723a_fw.zip;name=rtl8723a \
    https://raw.githubusercontent.com/OpenVisionE2/linux-firmwares/master/rtl8723aufw_B_NoBT.zip;name=rtl8723aufw \
"

SRC_URI[rtl8723a.md5sum] = "4ce2b5ba6dbdd726a41470969141dbb4"
SRC_URI[rtl8723a.sha256sum] = "400f600e5edf25069930ca5086e8151e69049c28a916b72b0bc47e3fafb279f4"

SRC_URI[rtl8723aufw.md5sum] = "f97d9b05b64a2f5a26861a986de94684"
SRC_URI[rtl8723aufw.sha256sum] = "cb6645a70278072041567db2b0c693b609018c6a0b44e99cee53ee36bf1aa0fa"

S = "${WORKDIR}"

PACKAGES = "${PN}"
FILES_${PN} += "${nonarch_base_libdir}/firmware"

inherit allarch

SUMMARY = "Firmware for rtl8723a"

do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware
    install -d ${D}${nonarch_base_libdir}/firmware/rtl_bt
    install -m 0644 rtl8723a_fw.bin ${D}${nonarch_base_libdir}/firmware/rtl_bt
    install -d ${D}${nonarch_base_libdir}/firmware/rtlwifi
    install -m 0644 rtl8723aufw_B_NoBT.bin ${D}${nonarch_base_libdir}/firmware/rtlwifi
}
