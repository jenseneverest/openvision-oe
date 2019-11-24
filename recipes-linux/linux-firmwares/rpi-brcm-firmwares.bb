SUMMARY = "Firmware files for RPi broadcom"
LICENSE = "CLOSED"
require conf/license/license-close.inc

PACKAGE_ARCH = "all"

SRC_URI = "https://raw.githubusercontent.com/OpenVisionE2/linux-firmwares/master/rpi-brcm-firmwares.zip"

SRC_URI[md5sum] = "ab8f3cac6a0ea1b807a9863f61af63c9"
SRC_URI[sha256sum] = "e740b46ce11afe5a035273fb3e2f81d78c64c73e0017c82147eccec03c9cb1e1"

S = "${WORKDIR}"

PACKAGES = "${PN}"
FILES_${PN} += "${nonarch_base_libdir}/firmware/brcm"

do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware/brcm
    install -m 0644 *.bin ${D}${nonarch_base_libdir}/firmware/brcm/
    install -m 0644 *.hcd ${D}${nonarch_base_libdir}/firmware/brcm/
    install -m 0644 *.txt ${D}${nonarch_base_libdir}/firmware/brcm/
}
