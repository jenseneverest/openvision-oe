# make the package version depend on the name/version of the distro
# this is required for release-to-release upgrades.

do_install_basefilesissue[vardeps] += "DISTRO_NAME DISTRO_VERSION"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PACKAGE_ARCH = "${MACHINE_ARCH}"

hostname = "${MACHINE}"

SRC_URI += "file://utf8.sh"
SRC_URI += "file://mount-helper.sh"

do_install_append() {
    rm -rf ${D}/autofs
    rm -rf ${D}/mnt
    rm -rf ${D}/hdd
    ln -sf media/hdd ${D}/hdd
    ln -sf media ${D}/mnt
    rm -rf ${D}/media/*
    rm -fr ${D}/tmp
    mkdir ${D}/media/net
    install -d ${D}${sysconfdir}/udev
    install -m 0755 ${WORKDIR}/mount-helper.sh       ${D}${sysconfdir}/udev
    install -d ${D}${sysconfdir}/profile.d
    install -m 0644 ${WORKDIR}/utf8.sh   ${D}${sysconfdir}/profile.d/utf8.sh

    # Inject machine specific blacklists into mount-helper:
    perl -i -pe 's:(\@BLACKLISTED\@):${MTD_BLACK}:s' ${D}${sysconfdir}/udev/mount-helper.sh

    # For machines that should mount their boot partition, inject it (Set MTD_BOOTFS and MACHINE_FEATURES+="mountboot" in machine config!
    if ${@bb.utils.contains("MACHINE_FEATURES","mountboot","true","false",d)}; then
        export BOOTFS_BLOCK=$(echo -e ${MTD_BOOTFS} | perl -pe 's:(mtd)(\d):${1}block$2:') ; perl -i -pe 's:(\@rootfs\@):/dev/'${BOOTFS_BLOCK}'\t\t/boot\t\tauto\t\tdefaults\t\t\t\t1  1\n${1}:s' ${D}${sysconfdir}/fstab
    fi

    if [ "${MACHINE}" = "azboxhd" ]; then
        printf "/dev/hda3\t\tswap\t\tswap\t\tdefaults\t\t\t\t0  0\n" >> ${D}${sysconfdir}/fstab
    fi
    if [ "${MACHINE}" = "sf4008" -o "${MACHINE}" = "sf5008" ]; then
        printf "/dev/mmcblk0p5\t\tnone\t\tswap\t\tsw\t\t\t\t\t0  0\n" >> ${D}${sysconfdir}/fstab
    fi
}
