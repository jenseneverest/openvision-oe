SUMMARY = "Driver for Realtek USB wireless devices"
HOMEPAGE = "http://www.realtek.com/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://os_dep/linux/os_intfs.c;endline=19;md5=72c75de415f1e8a42587d170459677e2"

SRC_URI = " \
    https://raw.githubusercontent.com/OpenVisionE2/linux-firmwares/master/rtl8188C_8192C_usb_linux_v4.0.2_9000.20130911.tar.gz \
    file://r8192cu_remove_debug.patch \
    file://rt8192cu-strncasecmp.patch \
    file://rtl8192cu-makefile.patch \
    file://rtl8192cu-gcc5.patch \
    file://rtl8192cu-fix_ndo_select_queue.patch \
    file://CHECKSM_IPV6_H.patch \
    "

SRC_URI[md5sum] = "efb71a576f781c3d15531511aac2c5c9"
SRC_URI[sha256sum] = "219b214a6a86408f898a94321988363718be0e26f30512c38bdd5ba3cb371856"

S = "${WORKDIR}/rtl8188C_8192C_usb_linux_v4.0.2_9000.20130911"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit module machine_kernel_pr siteinfo

EXTRA_OEMAKE = "CONFIG_RTL8192CU=m KDIR=${STAGING_KERNEL_DIR}"

do_configure() {
        sed -e "s/^CONFIG_PLATFORM_I386_PC.*=.*y/EXTRA_CFLAGS += -DCONFIG_${@oe.utils.conditional('SITEINFO_ENDIANNESS', 'le', 'LITTLE', 'BIG', d)}_ENDIAN/" -i Makefile
}
do_compile() {
        unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
        oe_runmake -C "${STAGING_KERNEL_DIR}" M="${S}" modules 
}

do_install() {
        install -d ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
        if [ "${TARGET_ARCH}" = "sh4" ]; then
            install -m 0644 ${S}/8192cu.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless/rtl8192cu.ko
        else
            install -m 0644 ${S}/8192cu.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
        fi
}
