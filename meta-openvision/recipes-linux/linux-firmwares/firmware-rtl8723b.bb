LICENSE = "CLOSED"
require conf/license/license-close.inc
SRC_URI = "https://raw.githubusercontent.com/OpenVisionE2/linux-firmwares/master/rtl8723b_fw.zip"

SRC_URI[md5sum] = "83001c39d647b741c4fb7ffe17344081"
SRC_URI[sha256sum] = "924645e1278746b3d1498f14d46c5ed975574e6d577d86cf7dbf6d21a4ae8934"

S = "${WORKDIR}"

PACKAGES = "${PN}"
FILES_${PN} += "${nonarch_base_libdir}/firmware"

inherit allarch

SUMMARY = "Firmware for rtl8723b"

do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware/rtl_bt
    install -m 0644 rtl8723b_fw.bin ${D}${nonarch_base_libdir}/firmware/rtl_bt
}
